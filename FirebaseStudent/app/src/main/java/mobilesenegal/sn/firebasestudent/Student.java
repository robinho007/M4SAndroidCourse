package mobilesenegal.sn.firebasestudent;

/**
 * Created by DELL on 07/08/2016.
 */
public class Student {

    private String id;
    private String firstName;

    public Student() {
        this.id = "0";
        this.firstName = "Foo";
    }

    public Student(String id, String firstName) {
        this.id = id;
        this.firstName = firstName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
