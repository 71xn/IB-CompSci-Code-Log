# Finn Lestrange 2020
# Drink Suggester - Coffee or Soda


def checker(nameinput):
    if nameinput.count("e") == 2 or nameinput.count("E") == 2 or nameinput.count("e") == 1 and nameinput.count(
            "E") == 1 or nameinput.count("E") == 2:
        drink = "coffee"
        print(nameinput + "'s drink is: " + drink)
    else:
        drink = "soda"
        print(nameinput + "'s drink is: " + drink)


def anothername():
    print("Would you like to check another name?, Y or N")
    againname = input()
    if againname == 'Y' or againname == 'y' or againname == 'yes' or againname == 'Yes':
        print("What is your name?:")
        name = input()
        checker(name)
    elif againname == 'N' or againname == 'n' or againname == 'no' or againname == 'No':
        exit()
    else:
        print("Sorry please enter a Y or an N: ")
        anothername()


time = 0
i = 0

while i >= 0:
    if time == 0:
        time += 1
        print("What is your name?:")
        name = input()
        checker(name)
    else:
        anothername()
