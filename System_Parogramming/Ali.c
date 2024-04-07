#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <pthread.h>
#include <sys/wait.h>

#define NUM_THREADS 6

void *thread_function(void *thread_id) {
    int tid = *((int *) thread_id);
    printf("Thread number %d\n", tid);
    pthread_exit(NULL);
}

int main() {
    pid_t pid;
    int x = 6; // Third digit of the student ID
    int thread_ids[NUM_THREADS];
    pthread_t threads[NUM_THREADS];

    pid = fork();

    if (pid < 0) {
        fprintf(stderr, "Fork failed\n");
        return 1;
    } else if (pid == 0) { // Child process
        for (int i = 0; i < x; i++) {
            thread_ids[i] = i + 1;
            pthread_create(&threads[i], NULL, thread_function, (void *) &thread_ids[i]);
        }

        for (int i = 0; i < x; i++) {
            pthread_join(threads[i], NULL);
        }

        printf("Exiting child process - Good Bye\n");
        exit(0);
    } else { // Parent process
        wait(NULL);
        printf("Child process exited - Goodbye\n");
    }

    return 0;
}
