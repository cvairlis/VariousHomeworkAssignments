# VariousHomeworkAsignments
Various Homework and Asignments.

Να αναπτύξετε πρόγραμμα σε Java το οποίο να επιτρέπει μέσω γραφικής διασύνδεσης χρήστη (gui) διάβασμα πληροφοριών φοιτητών από ένα αρχείο κειμένου .txt και εκτύπωση των πληροφοριών αυτών στη κονσόλα.
Κάθε φοιτητής (Student) χαρακτηρίζεται από 2 πεδία: επίθετο (surname: String), αριθμό μητρώου (am: int).
Υποκατηγορία φοιτητή είναι ο μεταπτυχιακός φοιτητής (PostgraduateStudent) οι οποίος χαρακτηρίζεται από ένα επιπλέον πεδίο: αριθμός προηγούμενων πτυχίων (numberOfTitles: int).
Το αρχείο κειμένου (students.txt) περιέχει πληροφορίες και για τα 2 είδη φοιτητών και έχει την παρακάτω μορφή:
Alfas, 00001
Vitas, 00002
Gamas, 00003
Deltas, 20002, 1
Epsilos, 20001, 2
Zhtas, 44001
Κάθε γραμμή του αρχείου .txt περιέχει 2 στοιχεία για κάθε φοιτητή ενώ για κάθε μεταπτυχιακό φοιτητή περιέχει 3 στοιχεία.
(Hint: χρησιμοποιείστε StringTokenizer και τη μέθοδο countTokens για την κλήση του κατάλληλου κατασκευαστή αντικειμένων για κάθε γραμμή του αρχείου .txt).

Πέρα από τις κλάσεις των φοιτητών και της ανάγνωσης από το αρχείο .txt να αναπτύξετε κώδικα που να κατασκευάζει γραφικό περιβάλλον (jframe). Το jframe πρέπει να περιέχει 2 jbutton. 
Με το πάτημα του πρώτου jbutton το πρόγραμμα θα διαβάζει το αρχείο .txt και θα κατασκευάζει τους φοιτητές. Με το πάτημα του δεύτερου jbutton το πρόγραμμα να εκτυπώνει στη κονσόλα τις πληροφορίες όλων των φοιτητών που διάβασε στη μορφή:
-	Student: “O foithths Alfas exei arithmo mhtrwou 00001”
-	PostgraduateStudent: “O foithths Deltas exei arithmo mhtrwou 20002. Einai epipleon metaptyxiakos foithths kai meta to peras ths trexousas foithshs tou tha katexei synolika 2 ptyxia.”

Δίνεται το αρχείο students.txt.

Μιλάμε ουσιαστικά για μια άσκηση που βασίζεται στη χρήση:
-	Inheritance with super method invocation.
-	Reading from txt file.
-	Jframe creation
-	Implementing ActionListeners.
