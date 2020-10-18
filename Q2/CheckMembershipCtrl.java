public class CheckMembershipCtrl {
    private TeamDAO teamDAO;

    public CheckMembershipCtrl() {
        teamDAO = new TeamDAO();
    }

    // complete the checkMembershipDuration method here
    public int checkMembershipDuration(String studentName, String teamName) {
        Team team = teamDAO.retrieve(teamName);
        Student student = team.retrieve(studentName);

        if (student == null){
            return null;
        }

        TMSDate dateJoined = student.getDateJoined();
        TMSDate dateFormed = team.getDateFormed();
        int result = dateJoined.calculateDifference(dateFormed);

        return result;
    }
}
