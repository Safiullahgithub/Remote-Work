% Given plant parameters
K = 5;
T1 = 4;
T2 = 6;
L = 12;

% plant transfer function
s = tf('s');
G_p = K * (1 - L*s) / ((T1*s + 1) * (T2*s + 1));

% Desired closed-loop transfer function
T_d = 2;
G_cl = 1 / (T_d * s + 1);

% Controller transfer function using Direct Synthesis
G_c = G_cl / G_p;

% Display the designed controller
disp('Designed Controller G_c(s):');
G_c

% Define the PID controller parameters 
[Kp, Ki, Kd] = pidtune(G_c, 'PID');

% Implement the Smith Predictor structure in Simulink
open_system('smith_predictor_model'); 
