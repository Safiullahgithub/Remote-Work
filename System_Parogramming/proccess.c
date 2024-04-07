#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <signal.h>

// Function to handle the child process behavior
void child_process(int id) {
    while (1) {
        printf("Process %d\n", id);
        sleep(5);
    }
}

int main() {
    int student_id = 1068045;
    int second_digit = (student_id / 100000) % 10;
    int num_children = (second_digit == 0 || second_digit == 1) ? 6 : second_digit;
    pid_t child_pids[num_children];

    // Print the initial process ID
    printf("Parent Process ID: %d\n", getpid());

    // Create child processes
    for (int i = 0; i < num_children; i++) {
        pid_t pid = fork();

        if (pid == 0) {
            // Child process behavior
            child_process(getpid());
            exit(0);
        } else if (pid < 0) {
            perror("fork");
            exit(1);
        } else {
            // Store child process ID in the array
            child_pids[i] = pid;
        }
    }

    // Parent process waits for child processes to terminate and restarts them if they die
    while (1) {
        for (int i = 0; i < num_children; i++) {
            int status;
            pid_t result = waitpid(child_pids[i], &status, WNOHANG);

            if (result == -1) {
                // Error in waitpid
                perror("waitpid");
            } else if (result == 0) {
                // Child process is still running
                continue;
            } else {
                // Child process has terminated, restart it
                pid_t pid = fork();

                if (pid == 0) {
                    child_process(getpid());
                    exit(0);
                } else if (pid < 0) {
                    perror("fork");
                    exit(1);
                } else {
                    child_pids[i] = pid;
                }
            }
        }

        // Wait for 1 second before checking again
        sleep(1);
    }

    return 0;
}
