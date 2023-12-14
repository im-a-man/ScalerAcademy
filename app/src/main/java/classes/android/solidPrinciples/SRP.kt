package classes.android.solidPrinciples

/**Single Responsibility Principle*/

/** Before Applying SRP */
class ReportGenerator_BeforeApplyingSRP {
    //The ReportGenerator class has the responsibility of both generating and saving reports.
    //If the logic for generating or saving reports changes, the class needs modification, violating SRP.
    fun generateReport(data: List<String>): String {
        // Generate report logic
        return "Generated Report"
    }

    fun saveReportToFile(report: String) {
        // Save report to file logic
        println("Saved report to file")
    }
}

/** After Applying SRP */
//Separate the responsibilities into distinct classes.
class ReportGenerator_AfterApplyingSRP {
    fun generateReport(data: List<String>): String {
        // Generate report logic
        return "Generated Report"
    }
}

class ReportSaver_AfterApplyingSRP {
    fun saveReportToFile(report: String) {
        // Save report to file logic
        println("Saved report to file")
    }
}