% Plant parameters
T1 = 4; % time constant 1
T2 = 6; % time constant 2
K = 5;  % steady-state gain
theta = 12; % dead time
tau = 2; % desired time constant

% Plant transfer function (with first-order Taylor expansion for time delay)
numG = [5 -60];
denG = conv([4 1], [6 1]);
G = tf(numG, denG);

% Desired closed-loop transfer function
G_cl = tf(1, [2 1]);

% Controller design using Direct Synthesis method
G_c = G_cl / (G * (1 - G_cl));

% Manual PID tuning (you can adjust these gains based on performance)
Kp = 0.8; % Proportional gain
Ki = 0.2; % Integral gain
Kd = 0.1; % Derivative gain

% Implement the PID controller
C = pid(Kp, Ki, Kd);

% Closed-loop transfer function
T = feedback(C * G, 1);

% Simulation time
t = 0:0.1:100;

% Step response
[y, t] = step(T, t);

% Control signal calculation using feedback
u = zeros(size(t));
e = zeros(size(t));
for i = 2:length(t)
    e(i) = 1 - y(i); % Error signal (difference from set-point)
    u(i) = u(i-1) + Kp * (e(i) - e(i-1)) + Ki * e(i) + Kd * ((e(i) - e(i-1)) / (t(i) - t(i-1))); % PID control law
end

% Plotting
figure;
subplot(2, 1, 1);
plot(t, y, 'b', 'LineWidth', 2);
hold on;
plot(t, ones(size(t)), 'r--', 'LineWidth', 2);
xlabel('Time (minutes)');
ylabel('Output');
title('Step Response');
legend('Output', 'Set-Point');

subplot(2, 1, 2);
plot(t, u, 'k', 'LineWidth', 2);
xlabel('Time (minutes)');
ylabel('Control Variable u(t)');
title('Control Signal');
grid on;
