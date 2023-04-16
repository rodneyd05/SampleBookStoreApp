package com.thisisit.samplebookstoreapp

data class Book(
    val title: String,
    val author: String,
    val image: Int)

val bookList = listOf(
    Book("Android Programming: The Big Nerd Ranch Guide (Big Nerd Ranch Guides) 3rd Edition", "Bill Phillips, Chris Stewart, Kristin Marsicano", R.raw.image001),
    Book("Head First Android Development: A Brain-Friendly Guide 2nd Edition", "Dawn Griffiths, David Griffiths", R.raw.image002),
    Book("Java Programming for Android Developers For Dummies (For Dummies (Computers)) 2nd Edition, Kindle Edition", "Barry Burd", R.raw.image003),
    Book("Android Application Development All-in-One For Dummies 2nd Edition", "Barry Burd", R.raw.image004),
    Book("GUI Design for Android Apps 1st ed. Edition, Kindle Edition", "Ryan Cohen, Tao Wang", R.raw.image005),
    Book("The Busy Coder's Guide to Advanced Android Development 0002- Edition", "Mr. Mark L Murphy", R.raw.image006),
    Book("Professional Android 4th Edition", "Reto Meier, Ian Lake", R.raw.image007),
    Book("Android Design Patterns: Interaction Design Solutions for Developers 1st Edition, Kindle Edition", "Greg Nudelman", R.raw.image008),
    Book("Beginning Android Games 3rd ed. Edition", "Mario Zechner, J. F. DiMarzio, Robert Green", R.raw.image009)
)

val myBookList = listOf(
    Book("GUI Design for Android Apps 1st ed. Edition, Kindle Edition", "Ryan Cohen, Tao Wang", R.raw.image005),
    Book("Beginning Android Games 3rd ed. Edition", "Mario Zechner, J. F. DiMarzio, Robert Green", R.raw.image009)

)
