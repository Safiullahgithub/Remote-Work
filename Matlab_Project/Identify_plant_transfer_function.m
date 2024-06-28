% Define the given parameters
T1 = 4;   % Time constant 1 in minutes
T2 = 6;   % Time constant 2 in minutes
K = 5;    % Steady-state gain
tau_d = 12; % Dead time in minutes

% Define the transfer function variable 's'
s = tf('s');

% Define the plant transfer function G(s)
G = K / ((T1 * s + 1) * (T2 * s + 1)) * exp(-tau_d * s);

% Display the plant transfer function
disp('The plant transfer function G(s) is:');
G
