package ua.edu.ucu;


class Student {

    private final double GPA;
    private final int year;
    private final String name;
    private final String surname;

    public Student(String name, String surname, double GPA, int year) {
        this.GPA = GPA;
        this.year = year;
        this.name = name;
        this.surname = surname;
    }

    public double getGPA() {
        return GPA;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Student{name=" + name + ", surname=" + surname + ", " + "GPA=" + GPA + ", year=" + year + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            return toString().compareTo(obj.toString()) == 0;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return name.charAt(0) + 10*surname.charAt(0) + (int)(GPA*10000) + year*1000;
    }
}