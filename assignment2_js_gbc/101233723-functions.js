function q1(myarray, value) {
    let counter = 0;
    for (let i = 0; i < myarray.length; i++) {
        if (myarray[i] == value)
            counter++;
    }
    return counter;
}

function q2(myarray, start, end, delimeter) {
    let str = "";
    for (let i = 0; i < myarray.length; i++) {
        if (i >= start && i <= end) {
            str += (i != myarray.length - 1) ? myarray[i] + "" + delimeter : myarray[i];
        }
    }
    return str;
}

function q3(str, numSpace) {
    let newStr = "";
    for (let i = 0; i < numSpace; i++) {
        newStr += " ";
    }
    newStr += str;
    for (let i = 0; i < numSpace; i++) {
        newStr += " ";
    }
    return newStr;
}
//could have made function for upper/lower case but will keep this way
function q4(str, pos) {
    let newStr = ""
    for (let i = 0; i < str.length; i++) {
        let c = str.charCodeAt(i);
        if (pos === 'even') {
            if (i % 2 !== 0) {
                //converting with ascii to lower
                if (c >= 97 && c <= 122)
                    newStr += String.fromCharCode(c - 32);
                //converting with ascii to upper
                else if (c >= 65 && c <= 90)
                    newStr += String.fromCharCode(c + 32);
                else
                    newStr += str.charAt(i);
            } else {
                newStr += str.charAt(i);
            }
        } else if (pos === 'odd') {
            if (i % 2 === 0) {
                if (c >= 97 && c <= 122)
                    newStr += String.fromCharCode(c - 32);
                else if (c >= 65 && c <= 90)
                    newStr += String.fromCharCode(c + 32);
                else
                    newStr += str.charAt(i);
            } else {
                newStr += str.charAt(i);
            }
        }
    }
    return newStr;
}

function q5(myarray, num) {
    let isOdd = true;
    if (num % 2 === 0) {
        isOdd = false;
    }
    let sum = 0;
    for (let i = 0; i < myarray.length; i++) {
        if (isOdd) {
            if (myarray[i] % 2 !== 0) {
                sum += myarray[i];
            }
        } else {
            if (myarray[i] % 2 === 0) {
                sum += myarray[i];
            }
        }
    }
    return sum;
}

function q6(txt) {
    let newStr = "";
    for (let i = 0; i < txt.length; i++) {
        if (txt.charAt(i) !== ' ' && txt.charAt(i) !== '\t' && txt.charAt(i) !== '\n')
            newStr += txt.charAt(i);

    }
    return newStr.length;
}

function q7(txt) {
    let newStr = "";
    var doneTrimming = false
    for (var i = 0; i < txt.length; i++) {
        if (txt.charAt(i) !== ' ' && txt.charAt(i) !== '\t' && txt.charAt(i) !== '\n')
            doneTrimming = true

        if (doneTrimming) {
            newStr += txt.charAt(i);
        }
    }
    return newStr;

}

function q8(txt) {
    let newStr = "";
    for (let i = 0; i < txt.length; i++) {
        let c = txt.charCodeAt(i);
        if (c >= 97 && c <= 122)
            newStr += String.fromCharCode(c - 32);
        else
            newStr += txt.charAt(i);
    }
    return newStr;
}

function q9(str, salt, n) {
    let newStr = "";
    newStr += str.charAt(0);
    for (let i = 1; i < str.length; i++) {
        if (i % n === 0) {
            newStr += str.charAt(i);
            newStr += salt;

        } else {
            newStr += str.charAt(i);
        }
    }
    return newStr;
}

function q10(myarray, value) {
    let returnVal = value;
    for (let i = 0; i < myarray.length; i++) {
        if (myarray[i] > value) {
            returnVal = myarray[i];
            break;
        }
    }
    return returnVal;
}

// console.log(q1([1, 2, 2, 2], 2));
// console.log(q2([1, 2, 3, 4], 1, 3, '*'));
// console.log(q3("hi", 5))
// console.log(q4('abCd', 'odd'));
// console.log(q5([1, 1, 2, 3, 4], 11));
// console.log(q6('a \n b \t c d'));
// console.log(q7('\n\t value '));
// console.log(q8('hi'));
// console.log(q9('abcdef123', 'ZZZ', 2));
// console.log(q10([5, 15, 4], 6));
console.log(q5([1, 2, 3, 1, 3, 4, 5, 11], 101));