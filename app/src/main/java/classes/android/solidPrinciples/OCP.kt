package classes.android.solidPrinciples

/** Open/Closed Principle */

/** Before applying OCP */
//Adding a new type of report might require modification to the existing code.
//Go through after SRP

/** After applying OCP*/
//Introduce an interface to make the system open for extension.
//So new type of reports can be added easily.
interface Report {
    fun generate(): String
}

class FinancialReport : Report {
    override fun generate(): String {
        // Financial report generation logic
        return "Financial Report"
    }
}

class ReportSaver {
    fun saveReportToFile(report: Report) {
        // Save report to file logic
        println("Saved ${report.generate()} to file")
    }
}