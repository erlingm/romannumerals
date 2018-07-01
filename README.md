# romannumerals
An example of generating roman numerals from ints, from Kevlin Henney's "Get Kata" presentation

Link to presentation: https://www.youtube.com/watch?v=_M4o0ExLQCs

## Original code from the slide
```
def roman(number):
    multiples = [
        (1000, 'M', (900, 'CM'),
        (500, 'D',  (400, 'CD'),
        (100, 'C',  (90, 'XC'),
        (50, 'L',   (40, 'XL'),
        (10, 'X',   (9, 'IX'),
        (5, 'V',    (4, 'IV'),
        (1, 'I')
    ]
    result = ''
    for value, letters in multiples:
        result += (number // value) * letters
        number %= value
    return result
```
