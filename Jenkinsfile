node {
    stage ("checkout repo") {
        git branch: 'master',
            // credentialsId:'xx-xxx'
            url: 'https://github.com/EkaterinaBurtseva/training-api-tests.git'
    }

    stage ("build") {
        sh "./gradlew clean api-test:assemble"
    }

    stage ("run api tests") {
        sh "./gradlew api-test:test"
    }



    allure([
            includeProperties: false,
            jdk: '',
            properties: [],
            reportBuildPolicy: 'ALWAYS',
            results: [[path: 'api-test/build/allure-results']]
    ])


}