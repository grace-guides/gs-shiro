package grace.guides

import grails.gorm.transactions.Transactional

class Bootstrap {

    def init = { servletContext ->
        environments {
            development {
                loadSampleData()
            }
        }
    }

    def destroy = {
    }

    @Transactional
    protected void loadSampleData() {
        (1..9).each {
            new Post(title: "Grace 2022.0.${it} released").save()
        }
    }

}
