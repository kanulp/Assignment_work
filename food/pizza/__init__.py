NAME = "Pizza"
crust_choices = {
    "Thin": 10,
    "Medium": 20,
    "Thick": 30,
}

topping_choices = {
    "Mushroom": 10,
    "Tomato": 20,
    "Lettuce": 30,
    "Avocado": 40,
    "Chilli pepper": 50,
}


class Pizza:
    def __init__(self):
        self.crust = None
        self.toppings = []
        self.calories = 0

    def __str__(self):
        return f"""
        Pizza details:
        Crust: {self.crust}
        Toppings: {", ".join(self.toppings)}
        Calories: {self.calories}
        """

    def set_crust(self):
        incomplete = True
        crust_choices_keys = list(crust_choices.keys())
        while incomplete:
            print("Select from the following crusts: ")
            for index, choice in enumerate(crust_choices_keys, 1):
                print(f"{index}: {choice}")
            try:
                crust = int(input())
                crust = crust_choices_keys[crust - 1]
                self.crust = crust
                incomplete = False
            except (ValueError, IndexError):
                print("Invalid input please try again")

    def set_toppings(self):
        incomplete = True
        topping_choices_keys = list(topping_choices.keys())
        while incomplete:
            print("Enter comma separated choices. Select from the following toppings: ")
            for index, choice in enumerate(topping_choices_keys, 1):
                print(f"{index}: {choice}")
            try:
                toppings = input().split(",")
                toppings = map(int, toppings)
                toppings = [topping_choices_keys[i - 1] for i in toppings]
                self.toppings = toppings
                incomplete = False
            except (ValueError, IndexError):
                print("Invalid input please try again")

    def set_calories(self):
        self.calories = crust_choices[self.crust]
        for topping in self.toppings:
            self.calories += topping_choices[topping]

    def create_item(self):
        self.set_crust()
        self.set_toppings()
        self.set_calories()
