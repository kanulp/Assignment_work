import burger
import pizza

menu = (
    burger.NAME,
    pizza.NAME,
)


def order():
    print("MENU:")
    incomplete = True
    obj = None
    while incomplete:
        print("Select from the following stuffings: ")
        for index, choice in enumerate(menu, 1):
            print(f"{index}: {choice}")
        try:
            item = int(input())
            item = menu[item - 1]
            if item == burger.NAME:
                obj = burger.Burger()
            elif item == pizza.NAME:
                obj = pizza.Pizza()
            obj.create_item()
            print(obj)
            incomplete = False
        except (ValueError, IndexError):
            print("Invalid input please try again")


if __name__ == "__main__":
    order()
