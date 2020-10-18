
public class CheckScoreCtrl {
    private QuizDAO quizDAO;

    public CheckScoreCtrl() {
        quizDAO = new QuizDAO();
    }

    public double calculateDifferenceFromAverage(String studentName, String quizName) {
        Quiz quiz = quizDAO.retrieve(quizName);
        Student student = quiz.getStudent(studentName);
        double averageScore = quiz.getAverageScore();
        double studentScore = student.getScore();
        return studentScore - averageScore;
    }
}