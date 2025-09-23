def calculate_class_average(grades):
    average_grade_total = 0

    for students_grades in grades:
        student_grade_total = sum(students_grades)
        number_grades = len(students_grades)

        average_grade_total += student_grade_total / number_grades


    return round(average_grade_total / len(grades),2)

