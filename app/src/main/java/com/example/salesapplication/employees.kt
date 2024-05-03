package com.example.salesapplication

data class employees(
    @Exclude var employeeID: String? = "",
    var employeeName: String? = "",
    var employeeAge: String? = "",
    var employeeQualification: String? = ""
)
