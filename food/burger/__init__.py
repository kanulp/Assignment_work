NAME = "Burger"
stuffing_choices = (
    "Chicken",
    "Beef",
)
topping_choices = (
    "Mushroom",
    "Tomato",
    "Lettuce",
    "Avocado",
    "Chilli pepper",
)

sauce_choices = (
    "Yellow mustard",
    "BBQ",
    "Mayo",
    "Ketchup",
    "Bacon jam",
)


class Burger:
    def __init__(self):
        self.stuffing = None
        self.toppings = []
        self.sauces = []

    def __str__(self):
        return f"""
        Burger details:
        Stuffing: {self.stuffing}
        Toppings: {", ".join(self.toppings)}
        Sauces: {", ".join(self.sauces)}
        """

    def set_stuffing(self):
        incomplete = True
        while incomplete:
            print("Select from the following stuffings: ")
            for index, choice in enumerate(stuffing_choices, 1):
                print(f"{index}: {choice}")
            try:
                stuffing = int(input())
                stuffing = stuffing_choices[stuffing - 1]
                self.stuffing = stuffing
                incomplete = False
            except (ValueError, IndexError):
                print("Invalid input please try again")

    def set_toppings(self):
        incomplete = True
        while incomplete:
            print("Enter comma separated choices. Select from the following toppings: ")
            for index, choice in enumerate(topping_choices, 1):
                print(f"{index}: {choice}")
            try:
                toppings = input().split(",")
                toppings = map(int, toppings)
                toppings = [topping_choices[i - 1] for i in toppings]
                self.toppings = toppings
                incomplete = False
            except (ValueError, IndexError):
                print("Invalid input please try again")

    def set_sauces(self):
        incomplete = True
        while incomplete:
            print("Enter comma separated choices. Select from the following sauces: ")
            for index, choice in enumerate(sauce_choices, 1):
                print(f"{index}: {choice}")
            try:
                sauces = input().split(",")
                sauces = map(int, sauces)
                sauces = [sauce_choices[i - 1] for i in sauces]
                self.sauces = sauces
                incomplete = False
            except (ValueError, IndexError):
                print("Invalid input please try again")

    def create_item(self):
        self.set_stuffing()
        self.set_toppings()
        self.set_sauces()
