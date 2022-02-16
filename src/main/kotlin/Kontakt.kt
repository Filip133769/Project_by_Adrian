class Kontakt()
{
    //Varför frågetecken i kod?
    var FirstName:String? = null
    var LastName:String? = null
    var PhoneNumber: ArrayList<String?> = ArrayList()

    var Email: ArrayList<String?> =ArrayList()

    fun AddPhoneNumber()
    {
        println("Add Phone Numbers")
        PhoneNumber.add(readLine())
        //bra
    }

    fun AddFirstName()
    {
        println("Add First Name")
        FirstName= readLine()
        //bra
    }
    fun AddLastName()
    {
        println("Add Last Name")
        LastName= readLine()
        //bra
    }

    fun AddEmail()
    {
        println("Add Emails")
        Email.add(readLine())
        //bra
    }
    fun PrintContact()
    {
        println("Name:" + "  " + FirstName +" "+  LastName)//Upprepad kod
        println("Phone Number:" + " " + PhoneNumber)
        println("Email:" + " " + Email)
        //kan använda funktionen PrintSimpleContact istället för den översta println
    }
    //Lite onödig funktion
    fun PrintSimpleContact()
    {
        println("Name:" + " "+ FirstName +" "+  LastName)
        //Ska flyttas över PrintContact
    }
    fun EditContact()
    {
        //Kan använda 1 println
        println("What would you like to edit?")
        println("1=First name")
        println("2=Last name")
        println("3=Phonenumber")
        println("4=Email")
        //choice kan skapas högst upp
        val choice = readLine()!!.toInt()
        when (choice)
        {
            1 -> {
                if(FirstName!=null)
                {
                println("Edit first name")
                FirstName = readLine()
                }
                else if(FirstName==null){
                    AddFirstName()
                }
            }
            2 -> {
                if(LastName!=null){
                    println("Edit last name")
                    LastName= readLine()
                }
                else if(LastName==null){
                    AddLastName()
                }
            }
            3 -> {
                var PhoneChoiceToEdit =-1


                if (PhoneNumber.count()>0)
                {
                    println("Which number would you like to change?")
                    var i: Int = 1
                    for (x in PhoneNumber) {
                        println(i.toString() + ": " + x) //Upprepad kod, kan göras till en funktion istället
                        i = i + 1
                        }
                    PhoneChoiceToEdit = readLine()!!.toInt()

                    PhoneNumber[PhoneChoiceToEdit-1]= readLine()

                }
                else if(PhoneNumber.count()==0)
                {
                    AddPhoneNumber()
                }

            }
            4->{
                var EmailChoiceToEdit=-1
                if (Email.count()>0)
                {
                    println("Which Email would you like to change?")
                    var i: Int = 1
                    for (x in Email) {                     //variabler högst upp
                        println(i.toString() + ": " + x)   //Upprepad kod, kan göras till en funktion istället
                        i = i + 1
                    }
                    EmailChoiceToEdit = readLine()!!.toInt()

                    Email[EmailChoiceToEdit-1]= readLine()

                }
                else if(Email.count()==0)
                {
                    AddEmail()
                }
            }
        }
    }


}
