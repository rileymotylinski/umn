# Template file for Lab03 -- weather. By Peter Wang and Daniel Kluver
# Additions made by: Your names here...

# Import Statements
import csv  # imported for DictReader
import math  # imported for


# provided functions -- one handles some tedious loading details, and the other can help make sure you know what you're
# working with -- it's worth reading both carefully, and trying to learn from what you're seeing.


def load(filename):
    """load the CSV file by name, return list of dictionaries, each dictionary describes one row. of the file"""
    reader = csv.DictReader(
        open(filename), dialect="excel", skipinitialspace=True
    )
    return list(reader)


# provided function
def min_min_temp(file_list):
    """The input is a list of dictionaries like would be returned by the load function. The output is the minimum temperature
    observed in the dataset. We are tacitly assuming that the min temperature for a day is always below the max temperature
    """
    min_temp = math.inf
    for row in file_list:
        row_min_temp = float(row["Min_Temperature"])
        if row_min_temp < min_temp:
            min_temp = row_min_temp
    return min_temp


# Put your functions below this.

def F_to_C(f_temp):
    '''
    converts fahrenheit to celsius via the following formula:

    (5/9)*(temp-32)
    '''
    return (5 * (f_temp - 32))/9

def F_to_C_file(file_list):
    '''
    converts temperatures in a specific csv file into celsius temperatures
    '''

    temperature_columns = [
        "Max_Temperature",
        "Min_Temperature"
    ]

    
    for i in range(len(file_list)):
        for column in temperature_columns:
            file_list[i][column] = F_to_C(float(file_list[i][column]))
        
def clean(file_list: list,column:str) -> list:
    special_values = ["T", "M", "S", "A", ""]
    clean_rows = []

    for row in file_list:
        if not row[column] in special_values:
            clean_rows.append(row)

    return clean_rows

def average(file_list, column) -> float:
    cleaned_data = clean(file_list, column)
    if len(cleaned_data) == 0:
        return 0.0
    values = [float(row[column]) for row in cleaned_data]

    average = sum(values) / len(values)
    print(average)
    return average
def total_rain_by_year(file_list):
    rainfall = {}

    for row in clean(file_list,"Precipitation"):
        year = int(row["Date"][:4])
        precipitation = float(row["Precipitation"])

        if year not in rainfall:
            rainfall.update({year: precipitation})
        else:
            rainfall[year] += precipitation

    return rainfall
