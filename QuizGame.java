import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
public class QuizGame {
    private static int score = 0;
    private static int currentQuestion = 0;
    private static boolean answered = false;
    private static String[] questions = {
            "What is the capital of France?",
            "Which planet is known as the Red Planet?",
            "What is the largest mammal in the world?",
            "Who wrote Romeo and Juliet?",
            "What is the chemical symbol for gold?"
    };
    private static String[][] options = {
            {"A) Rome", "B) Paris", "C) Berlin", "D) Madrid"},
            {"A) Venus", "B) Mars", "C) Jupiter", "D) Saturn"},
            {"A) Elephant", "B) Blue Whale", "C) Giraffe", "D) Polar Bear"},
            {"A) Charles Dickens", "B) William Shakespeare", "C) Jane Austen", "D) Mark Twain"},
            {"A) Au", "B) Ag", "C) Ge", "D) Fe"}
    };
    private static char[] correctAnswers = {'B', 'B', 'B', 'B', 'A'};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Quiz Game!");
        for (int i = 0; i < questions.length; i++) {
            presentQuestion(i, scanner);
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    if (!answered) {
                        System.out.println("\nTime's up! You didn't answer the question.");
                        System.exit(0);
                    }
                }
            }, 15000); // 15 seconds timer
            String userAnswer = scanner.next().toUpperCase();
            answered = true;
            timer.cancel();
            if (userAnswer.charAt(0) == correctAnswers[i]) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is " + correctAnswers[i] + ".\n");
            }
        }
        displayResult();
        scanner.close();
    }
    private static void presentQuestion(int index, Scanner scanner) {
        System.out.println("\nQuestion " + (index + 1) + ": " + questions[index]);
        for (String option : options[index]) {
            System.out.println(option);
        }
        System.out.print("Your answer (A/B/C/D): ");
        answered = false;
    }
    private static void displayResult() {
        System.out.println("Quiz completed!");
        System.out.println("Your final score is: " + score + "/" + questions.length);
        System.out.println("\nCorrect/Incorrect Answers Summary:");
        for (int i = 0; i < questions.length; i++) {
            char userAnswer = (char) ('A' + i);
            char correctAnswer = correctAnswers[i];
            System.out.println("Question " + (i + 1) + ": Your answer - " + userAnswer + ", Correct answer - " + correctAnswer);
        }
    }
}
