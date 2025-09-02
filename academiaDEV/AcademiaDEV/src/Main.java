//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import repository.InitialData;
import repository.course.CourseRepository;
import repository.course.InMemoryCourseRepository;
import repository.user.InMemoryUserRepository;
import repository.user.UserRepository;
import view.MainView;

public class Main {
    public static void main(String[] args) {
        // Initialize repositories
        UserRepository userRepository = new InMemoryUserRepository();
        CourseRepository courseRepository = new InMemoryCourseRepository();

        // Populate initial data
        InitialData initialData = new InitialData();
        initialData.populateData(userRepository, courseRepository);

        // view
        MainView mainView = new MainView();
        mainView.run();
    }
}