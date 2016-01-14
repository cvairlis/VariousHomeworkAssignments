# VariousHomeworkAssignments
Various Homework and Assignments

Να αναπτύξετε πρόγραμμα σε Java το οποίο να επιτρέπει μέσω γραφικής διασύνδεσης χρήστη (gui) διάβασμα πληροφοριών ξενοδοχείων από ένα δυαδικό αρχείο .ser και εκτύπωση των πληροφοριών αυτών σε λίστα (jlist) καθώς και στη κονσόλα με αξιοποίηση κατάλληλων κουμπιών (jbutton).

Κάθε ξενοδοχείο (Hotel) χαρακτηρίζεται από 2 πεδία: όνομα (name: String), αριθμό αστεριών (starts: int).
Επίσης κάθε ξενοδοχείο περιέχει και μία λίστα (ArrayList) με αντικείμενα κρατήσεων (Booking).
Κάθε κράτηση (Booking) χαρακτηρίζεται από 2 πεδία: όνομα δωματίου (roomName: String), μέρες κράτησης (days: int).
Υποκατηγορία κάθε κράτησης αποτελεί η ειδική κράτηση (SpecialBooking) με επιπλέον πεδίο: κόστος ειδικής κράτησης (specialBookingCost: double). Το επιπλέον πεδίο των αντικειμένων ειδικών κρατήσεων δεν αποτελεί παράμετρος στον κατασκευαστή αλλά υπολογίζεται και θέτεται με βάση τις μέρες κράτησης. Σημειώνεται ότι το κόστος της ειδικής κράτησης είναι 25 ευρώ τη μέρα.

Α. Να υλοποιήσετε κλάσεις για τη μοντελοποίηση των παραπάνω εννοιών. (2 μονάδες)

Β. Πέρα από τις κλάσεις Hotel, Booking & SpecialBooking, να υλοποιήσετε μια κλάση (LoadData) μέσω της οποία θα γίνεται η ανάγνωση του δυαδικού αρχείου hotels.ser. (3 μονάδες)

Γ. Αφού ολοκληρώσετε σωστά τα παραπάνω, να αναπτύξετε κώδικα που να κατασκευάζει γραφικό περιβάλλον (jframe). Το jframe πρέπει να περιέχει 4 jbutton και ένα jlist όπως φαίνεται και στην εικόνα παρακάτω. Πρέπει επίσης να υλοποιεί BorderLayout.
Με το πάτημα του jbutton “Read ser file” το πρόγραμμα θα διαβάζει και θα φορτώνει το αρχείο .ser το οποίο θα επιστρέφει λίστα με αντικείμενα ξενοδοχείων. 
Με το πάτημα του δεύτερου jbutton “Fill JList” το πρόγραμμα να γεμίζει την jlist με τα ονόματα των ξενοδοχείων που φορτώθηκαν από το αρχείο .ser.
Με το πάτημα του τρίτου jbutton “Fill Jlist with Hotels Sorted by Name” το πρόγραμμα να εκτελεί αύξουσα ταξινόμηση στη λίστα με τα αντικείμενα ξενοδοχείων (ταξινόμηση με βάση το όνομα κάθε ξενοδοχείου) και έπειτα να γεμίζει την jlist με τα ονόματα των ξενοδοχείων από τη ταξινομημένη πλέον λίστα.
Με το πάτημα του τέταρτου jbutton “Print Hotels Sorted” το πρόγραμμα να εκτελεί πάλι αύξουσα ταξινόμηση στη λίστα με τα αντικείμενα ξενοδοχείων (ταξινόμηση με βάση το όνομα κάθε ξενοδοχείου) και έπειτα να εκτυπώνει όλες τις πληροφορίες για όλα τα ξενοδοχεία που υπάρχουν στη λίστα. Για παράδειγμα στη κονσόλα να εκτυπώνεται το παρακάτω:

- Alfa Hotel, 3 stars. Number of bookings=2.
  Alfa Hotel Bookings:
  Booking [room=A48, days=3]
  Booking [room=B22, days=5]. SpecialBookingCost 125.0 for 5 days.
- Delta Hotel, 4 stars. Number of bookings=2.
  Delta Hotel Bookings:
  Booking [room=B34, days=5]
  Booking [room=V43, days=8]. SpecialBookingCost 200.0 for 8 days.
- Gama Hotel, 3 stars. Number of bookings=2.
  Gama Hotel Bookings:
  Booking [room=F43, days=7]
  Booking [room=S14, days=4]. SpecialBookingCost 100.0 for 4 days.
- Vita Hotel, 3 stars. Number of bookings=2.
  Vita Hotel Bookings:
  Booking [room=A64, days=4]
  Booking [room=F223, days=4]. SpecialBookingCost 100.0 for 4 days.

(5 μονάδες)

Δίνεται το αρχείο hotels.ser.

Μιλάμε ουσιαστικά για μια άσκηση που βασίζεται στη χρήση:
-	Inheritance with super method invocation.
-	Reading ArrayList of objects from .ser file (deserialize).
-	Jframe developing (BorderLayout).
-	Implementing ActionListeners.
-	JList & DefaultListModel.
-	Sorting Objects by field value.
