package Contact;

public class MVC {
    View_Contact view_contact = new View_Contact();
    Model_Contact model_contact = new Model_Contact();
    Controller_Contact controller_contact = new Controller_Contact(view_contact, model_contact);
}
