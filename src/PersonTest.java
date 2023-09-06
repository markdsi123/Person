public class PersonTest
{

    public static void main(String[] args)
    {

                Person Mark = new Person("000001", "Mark", "Dsilva", "Mr.", 2004);
                System.out.println(Mark.fullName());
                System.out.println(Mark.formalName());
                System.out.println(Mark.getAge());
                System.out.println(Mark.getAge(2012));
                System.out.println(Mark.toCSVDataRecord());



    }
}