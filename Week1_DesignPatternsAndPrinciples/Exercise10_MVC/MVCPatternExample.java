// DesignPattern: Exercise 10

package Week1_DesignPatternsAndPrinciples.Exercise10_MVC;

public class MVCPatternExample {

    static class Student {
        private String id;
        private String name;
        private String grade;

        public Student(String id, String name, String grade) {
            this.id = id;
            this.name = name;
            this.grade = grade;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }
    }

    static class StudentView {
        public void displayStudentDetails(String id, String name, String grade) {
            System.out.println("Student Details:");
            System.out.println("ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Grade: " + grade);
            System.out.println("-x-");
        }
    }

    static class StudentController {
        private Student model;
        private StudentView view;

        public StudentController(Student model, StudentView view) {
            this.model = model;
            this.view = view;
        }

        public void setStudentName(String name) {
            model.setName(name);
        }

        public void setStudentGrade(String grade) {
            model.setGrade(grade);
        }

        public String getStudentName() {
            return model.getName();
        }

        public String getStudentGrade() {
            return model.getGrade();
        }

        public void updateView() {
            view.displayStudentDetails(model.getId(), model.getName(), model.getGrade());
        }
    }

    public static void main(String[] args) {
        Student student = new Student("S101", "Alice", "A");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(student, view);

        controller.updateView();

        controller.setStudentName("Alice Johnson");
        controller.setStudentGrade("A+");

        controller.updateView();
    }
}
