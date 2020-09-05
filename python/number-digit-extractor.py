# Finn Lestrange - 02/09/2020
# Number Separator Program
# This code takes a number, preferably 5 digits or less and extracts each digit only using math

print('please input a number: ')

number = int(input())

last_digit = int(number % 10) 
# Modulo 10 just prints out the last digit e.g 56 % 10 produces 6 as 6 is the remainder
second_last = int(((number % 100) - last_digit) / 10) 
# % 100 gets last two digits, so we - last digit and then divide by 10 to get rid of zero's
third_last = int(((number % 1000) - second_last - last_digit) / 100)
# % 1000 gets last three digits so we have to subtract the last and 2nd last then divide 100 to get rid of the two zeros
fourth_last = int(((number % 10000) - second_last - last_digit - third_last) / 1000)
# % 10000 gets last three digits so we have to - last, 2nd last, 3rd last then divide 1000 to get rid of the three zeros
fifth_last = int(((number % 100000) - second_last - last_digit - third_last - fourth_last) / 10000)
# % 10000 gets last three digits so we have to - last, 2nd last, 3rd last then divide 1000 to get rid of the three zeros

# Print's all values in order separated by commas
print(fifth_last, ", ", fourth_last, ", ", third_last, ", ", second_last, ", ", last_digit)

# For six digit numbers, if not six digit then zero at the start
# sixth_last = int (((number % 1000000) - second_last - last_digit- third_last - fourth_last - fifth_last) / 100000)

# print(sixth_last, ", ", fifth_last, ", ", fourth_last, ", ", third_last, ", ", second_last, ", ", last_digit)
