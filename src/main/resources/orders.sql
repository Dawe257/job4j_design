select s.name, b.name, a.name
from orders
         join students s on orders.student_id = s.id
         join books b on b.id = orders.book_id
         join authors a on b.author_id = a.id