src:all the java file.
1.packages:Health.Care.Appointment.Booking.system.Health.Care.Appointment.Booking:
its for running the application.
2.Health.Care.Appointment.Booking.system.Health.Care.Appointment.Booking.ControllerLayer:
here all the end point logic written.
1.AppointmentController.java:for register appointment and cancel the appointment and view the registration.
2.DoctorController.java:doctor details and time and doctor for view doctor list.
3.EmailController.java:for sending email those who are register.
4.GlobalExceptionHandler.java:if any error means 400 or 500 it doesnot show it will show oops something went wrong.
5.UserController.java:for user sign up and login and profile update.


......another package....
7.Health.Care.Appointment.Booking.system.Health.Care.Appointment.Booking.Repository
1.AppointmentRepository.java:it provide the implimentation for the appoinment classes.
2.DoctorRepository.java:it also provide the implimentation for the doctor .
3.UserRepository.java:it provide the implimentation for the user classes.

.....another package.....
8.Health.Care.Appointment.Booking.system.Health.Care.Appointment.Booking.UserEntity
1.Appointment.java:it is use to create the table in the database for appoiniment class.
2.Doctor.java:it is create the table in the database for doctor class.
3.User.java:to create user table;
....another package....
9.Health.Care.Appointment.Booking.system.Health.Care.Appointment.Booking.UserService
1.AppointmentService.java:here we can write the logic for appointment class.
2.CustomMailSender.java:for sending email.
3.DoctorService.java:here we can write the logic for doctor class.
4.UserService.java:here we can write the logic for user class.


templates:for front end :
1.appointments.html:for appointment list.
2.book-appointment.html:for booking the appointment.
3.doctor.html:to register the doctor.
4.error-html:for any error handle.
5.list-doctor.html:to show list of doctor.
6.login.html:for login the user.
7.profile.html:it is the profile page.
8.register-doctor.html:canclel the registration .
9.signup.html:to login the user.
