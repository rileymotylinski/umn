'''
Author : Riley Motylinski
Lab Partners: Samir, Cardin
'''

import unittest
from isbn13 import check_isbn13, make_isbn13

class test_isbn(unittest.TestCase):
    def test_check_isbn13(self):
        self.assertTrue(check_isbn13(9780306406157))
        self.assertFalse(check_isbn13(978030640615))
    def test_make_isbn13(self):
        self.assertEqual(make_isbn13(978030640615),9780306406157)
        # should be 42 because even digits * 3 + odd digits should equal a number divisble by 10
        self.assertEqual(make_isbn13(4),42)
        self.assertEqual(make_isbn13(9),97)
        self.assertEqual(make_isbn13(978316148410),9783161484100)


if __name__ == '__main__':
    unittest.main()
