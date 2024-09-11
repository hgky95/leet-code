
def leap_year_identify(year):
    if year % 4 == 0 and year % 100 != 0 or year % 400 == 0:
        print("Leap Year")
    else:
        print("Not Leap Year")

leap_year_identify(1900)