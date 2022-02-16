import java.io.FileWriter

class KontaktHandler {

    var Contact_list:ArrayList<Kontakt?> = ArrayList()

    fun AddContact()
    {
        var i:Int = 0                           //variabler högst upp
        Contact_list.add(Kontakt())
        if (Contact_list.count()>0)
        {
            i=Contact_list.count()
            Contact_list[i-1]?.AddFirstName()
            Contact_list[i-1]?.AddLastName()
            Contact_list[i-1]?.AddPhoneNumber()
            Contact_list[i-1]?.AddEmail()
        }
    }
    fun RemoveContact()
    {
        var ContactChoiceToRemove = -1          //variabel högst upp
        if(Contact_list.count()>0)
        {

            println("Which contact would you like to remove")
            PrintSimpleContactList()
            var I:Int =0
            for (x in Contact_list){
                println(I.toString() + " " + x!!.FirstName + " " +  x!!.LastName)
                I =I+1
            }
            ContactChoiceToRemove= readLine()!!.toInt()-1
            if(ContactChoiceToRemove <0 )
            {
                println("Your choice has to be above 0")
                ContactChoiceToRemove = readLine()!!.toInt()-1
            }
            Contact_list.removeAt(ContactChoiceToRemove)
            //Bra funktion
            //Kan ej testas
        }
    }

    fun EditContact()
    {
        var ContactChoiceToEdit = -1            //Alla variabler högst upp!, slipper även att skapa samma variabel flera gånger
        if(Contact_list.count()>0)
        {
            println("Which contact would you like to edit")
            PrintSimpleContactList()
            var I:Int = 1
            for (x in Contact_list){
                println(I.toString() + " " + x!!.FirstName + " " + x!!.LastName)
                I=I+1
            }
            ContactChoiceToEdit= readLine()!!.toInt()
            if(ContactChoiceToEdit<0)
            {
                println("Your choice has to be above 0")
                ContactChoiceToEdit= readLine()!!.toInt()
            }
            Contact_list[ContactChoiceToEdit-1]!!.EditContact()
            //Godkänd funktion
        }
    }
    fun SortContactList()
    {
        var Index:Int = 0       //Variabler högst upp
        //val sortedAppsList = Contact_list.sortedBy { it!!.FirstName?.toString() }        //Ta bort ifall ej använd
        var ReplicaOfList:ArrayList<Kontakt?> = ArrayList() // kan vara val istället för var
        for (x in Contact_list)
        {
            ReplicaOfList.add((x))

        }
        //Förstår ej
        ReplicaOfList.sortedBy { it!!.FirstName.toString().compareTo(ReplicaOfList[Index+1]!!.FirstName.toString())}
        for (x in Contact_list)
        {
            Contact_list[Index]=ReplicaOfList[Index]
            Index=+1
        }
    }


    fun PrintContactList()
    {
        for (x in Contact_list){
            x!!.PrintContact()
            WriteToFile(x.FirstName.toString())
            WriteToFile(x.LastName.toString())
            WriteToFile(x.PhoneNumber.toString())
            WriteToFile(x.Email.toString())
            println("")
        }
    }
    fun PrintSimpleContactList()
    {
        for (x in Contact_list){
            x!!.PrintSimpleContact()
        }
    }
    fun WriteToFile(str:String){
            var FileHandler=FileWriter("ContactSavings.txt")  // Val istället för var
        FileHandler.write(str)
        FileHandler.close()
        //Ej klar funktion
    }
}

