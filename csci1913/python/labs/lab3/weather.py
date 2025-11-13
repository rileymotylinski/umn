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

    Args:
    f_temp -- flot -- temperature in fahrenheit
    Returns:
    float -- temperature in celsius
    '''
    return (5 * (f_temp - 32))/9

def F_to_C_file(file_list):
    '''
    converts temperatures in a specific csv file into celsius temperatures

    Args:
    file_list -- list[dict] -- list of dictionaries representing each row w/ the columns as keys

    Returns:
    None
    updates the file_list in palce to change the string valued fahrenheit temperature to float valued celsius temperatures
    '''
    # relevant columns to convert
    temperature_columns = [
        "Max_Temperature",
        "Min_Temperature"
    ]

    
    for i in range(len(file_list)):
        # updating each column to float celsius temperatures
        for column in temperature_columns:
            file_list[i][column] = F_to_C(float(file_list[i][column]))
        
def clean(file_list,column):
    '''
    removes any rows containg special characters from a certain column

    Args:
    file_list -- list[dict] -- list of dictionaries representing each row in the csv file
    column -- string -- column to be checked for special values

    Returns:
    list -- cleaned rows
    '''

    # special values that make a row need to be removed 
    special_values = ["T", "M", "S", "A", ""]
    clean_rows = []

    for row in file_list:
        # if the value is not present at file_list[row][column], then when can add it to clean rows
        if not row[column] in special_values:
            clean_rows.append(row)

    return clean_rows

def average(file_list, column) -> float:
    '''
    returns to average of a column

    Args:
    file_list -- list[dict] -- list of dictionaries representing each row in the csv file
    column -- string -- column to be averaged

    '''
    # have to remove special, not digit characters (can't average those)
    cleaned_data = clean(file_list, column)

    # average of no columns is zero
    if len(cleaned_data) == 0:
        return 0.0
    
    # pull the values to be averaged from the cleaned data, convert from string -> float
    values = [float(row[column]) for row in cleaned_data]

    # calculate average
    average = sum(values) / len(values)
    return average


def total_rain_by_year(file_list):
    '''
    calculates the total rainfall by year

    Args:
    file_list -- list[dict] -- list of dictionaries representing each row in the csv file

    Returns:
    dict -- dictionary with years as keys and the corresponding rainfall as values
    '''

    rainfall = {}

    # 
    for row in clean(file_list,"Precipitation"):
        # pull year from row and convert it to an integer
        year = int(row["Date"][:4])
        # precipitation for current row
        precipitation = float(row["Precipitation"])

        # year's rainfall has not already been tracked
        if year not in rainfall:
            # add a new entry
            rainfall.update({year: precipitation})
        # else year already exists in rainfall
        else:
            # add current precipitation to the total precipitation
            rainfall[year] += precipitation

    return rainfall
