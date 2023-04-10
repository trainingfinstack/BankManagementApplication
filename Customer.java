package customerRegistration.coreJava;

class Customer {
    int id;
    String name;
    int age;
    String mobile;


    Customer() {

    }

    Customer(int id, String name,int age, String mobile) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.mobile = mobile;

    }
    public int getId()
    {
        return id;
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getMobileNumber() {
        return mobile;
    }

}