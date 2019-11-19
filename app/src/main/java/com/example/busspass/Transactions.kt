package com.example.busspass

import com.google.firebase.Timestamp

data class Transactions (
        var uid: String = "",
        var time: Timestamp = Timestamp.now(),
        var transactionId: String = "",
        var amount: String = ""
)