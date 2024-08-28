pipelineJob("AAT_COMMON_CCRC_LOAD_TS") {
    authorization {
        permission('hudson.model.Item.Build:authenticated')
        permission('hudson.model.Item.Build:ewanlux')
        permission('hudson.model.Item.Cancel:authenticated')
        permission('hudson.model.Item.Cancel:ewanlux')
        permission('hudson.model.Item.Configure:ewanlux')
        permission('hudson.model.Item.Discover:authenticated')
        permission('hudson.model.Item.Discover:ewanlux')
        permission('hudson.model.Item.Read:anonymous')
        permission('hudson.model.Item.Read:authenticated')
        permission('hudson.model.Item.Read:ewanlux')
        permission('hudson.model.Item.Workspace:authenticated')
        permission('hudson.model.Item.Workspace:ewanlux')
        permission('hudson.scm.SCM.Tag:authenticated')
        permission('hudson.scm.SCM.Tag:ewanlux')
        permissionAll('ewanlux')
    }
    logRotator(-1, 30, -1, -1)
    concurrentBuild(false)

    parameters {
        stringParam ('GERRIT_BRANCH', 'master', '')
        stringParam ('GERRIT_REFSPEC', 'master', '')
        booleanParam("RELEASE", false, "")
    }

    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url ('https://${COMMON_GERRIT_URL}/a/5gcicd/aat-xcc-common-load-test-service-ci')
                        credentials ('userpwd-adp')
                        branch('${GERRIT_BRANCH}')
                    }
                }
            }
            scriptPath('cicd/${JOB_NAME}/Jenkinsfile.mason2')
        }
    }
    disabled(false)
}
