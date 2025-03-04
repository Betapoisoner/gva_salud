package service.auth;


import org.hibernate.Session;
import org.hibernate.Transaction;

import model.*;
import utils.hibernate.HibernateUtil;

import java.util.List;

public class AppointmentService {

    public void createAppointment(Appointment appointment) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(appointment);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public List<Appointment> getAppointmentsByPatient(UserInfo patient) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Appointment> appointments = session.createQuery(
                "FROM Appointment WHERE patient = :patient", Appointment.class)
                .setParameter("patient", patient)
                .list();
        session.close();
        return appointments;
    }

    public List<Appointment> getAppointmentsByDoctor(Doctor doctor) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Appointment> appointments = session.createQuery(
                "FROM Appointment WHERE doctor = :doctor", Appointment.class)
                .setParameter("doctor", doctor)
                .list();
        session.close();
        return appointments;
    }
}