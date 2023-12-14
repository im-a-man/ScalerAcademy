package classes.android.solidPrinciples

/** Dependency Inversion Principle */
//High-level modules should not depend on low-level modules; both should depend on abstractions.
//Classes may still be tightly coupled with specific implementations, making it challenging to switch implementations or extend the system.

//Solution=>
//Depend on abstractions (interfaces or abstract classes) rather than concrete implementations. Invert the direction of dependency.

interface Report___ {
    fun generate(): String
}

interface ReportSaver__ {
    fun save(report: Report): Boolean
}

class FinancialReport___ : Report {
    override fun generate(): String {
        // Financial report generation logic
        return "Financial Report"
    }
}

class DummyReport_ : Report {
    override fun generate(): String {
        // Dummy report generation logic
        return "Dummy Report"
    }
}

class DatabaseReportSaver : ReportSaver__ {
    override fun save(report: Report): Boolean {
        // Save report to database logic
        println("Saved report to database")
        return true
    }
}
