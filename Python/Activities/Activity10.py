# Given tuple
#num_tuple = (10, 20, 33, 46, 55)

values = input("Input some comma seprated numbers : ")
list = values.split(",")
num_tuple = tuple(list)

print("Given list is ", num_tuple)

# Print elements that are divisible by 5
print("Elements that are divisible by 5:")
for num in num_tuple:
    if (int(num) % 5 == 0):
        print(num)