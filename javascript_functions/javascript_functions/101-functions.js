function Calling_one() {
    let name = "Karan";
    let studentNo = "1234567890";
    let noOfCourse = 2;
    let program = "IT";
    let is_PartTimeJob = false;
    let haveStr = "";
    if (is_PartTimeJob) {
        haveStr = "have";
    } else {
        haveStr = "don't have";
    }

    console.log("My name is " + name + " and I'm in " + program + " program. I am currently taking " + noOfCourse + " courses and I " + haveStr + " a part time job now.");
}

function Calling_two(age, year_to_graduate) {
    let d = new Date();
    let currentYear = d.getFullYear();
    age = currentYear - age;
    year_to_graduate = year_to_graduate + currentYear;
    console.log("You were born the year : " + age);
    console.log("You will graduate from college in year " + year_to_graduate);
}

function Calling_three(celsius, fahrenheith) {
    let cToF = (celsius * (9 / 5) + 32);
    let fToC = (fahrenheith - 32) * (5 / 9);

    console.log(celsius + "\xB0C is " + cToF + " \xB0F");
    console.log(fahrenheith + "\xB0F is " + fToC + " \xB0C");
}

function Calling_four(n) {
    let sumOdd = 0;
    let sumEven = 0;
    for (let index = 1; index <= n; index++) {
        if (index % 2 == 0) {
            sumEven += index;
        } else {
            sumOdd += index;
        }
    }
    console.log("Odd sum = " + sumOdd + " and Even sum = " + sumEven);
}

function Calling_five(num1, num2, num3) {
    let max = num1;
    if (num2 > max) {
        max = num2;
    }
    if (num3 > max) {
        max = num3;
    }
    console.log("Maximum number is : " + max);
}

function Calling_six() {
    let largest = arguments[0];
    let smallest = arguments[0];
    for (let i = 0; i < arguments.length; i++) {
        let temp = arguments[i];
        if (temp > largest) {
            largest = arguments[i];
        }
        if (temp < smallest) {
            smallest = arguments[i];
        }
    }
    console.log("The larger value is : " + largest + " and the smaller value is " + smallest);
}

function Calling_seven(first_number, second_number) {
    for (let index = 1; index <= second_number; index++) {
        console.log(first_number + " x " + index + " = " + (first_number * index));
    }
}

function Calling_eight(letter) {
    if (letter === letter.toUpperCase()) {
        console.log(letter + " is an Uppercase letter")
    } else {
        console.log(letter + " is not an Uppercase letter")
    }
}

/* Calling_one();
Calling_two(0, 7);
Calling_three(9, 0);
Calling_four(5);
Calling_five(5, 9, 6);
Calling_six(-54, -57, -13, -88, -77, -50, -69);
Calling_seven(4, 3);
Calling_eight("q"); */