INSERT INTO topic (name, description) VALUES 
('Novel Pick', 'American novelist Cormac McCarthy''s *No Country for Old Men*, now a movie, is the source for our quiz. The plot pits good against evil. Here, It''s your vacabulary skill vs ours.'),
('Decorator''s Delight', 'The post monsoon season is the perfect time t oshake off the decor doldrums and set your inner home stylist free. Before you start testing paint chips and fabic swatches, test yourself with this month''s quiz, full of words you might encounter while sprucing up.');


INSERT INTO question (topic_id, name, key, ans )VALUES
(1, 'avert', 'A', 'To turn away or aside. As the king entered the great hall, all his subjects *averted* their eyes until he was seated upon the throne'),
(1, 'flail', 'B', 'To wave, swing vigorously; thrash. They could see him standing by the side of the road; *flailing* his arms, as they drove off without him'),
(2, 'cabriole', 'B', 'Curved furniture leg. "That *cabriole* shape mimics Rufu''s hind leg!" the collector''s son boasted'),
(2, 'trug', 'A', 'Shallow basket. Barbaras''s hand made *trugs* are ideal for carring floweres' ),
(2, 'bolster', 'C', 'Long pillow. A pair of comfy *bolster* soften the ends of a day bed');

INSERT INTO choice (question_id, label, name) VALUES
(1, 'A','to turn away'),
(1, 'B', 'return to owner'),
(1, 'C', 'distract'),
(2, 'A', 'to prove deficient'),
(2, 'B', 'swing vigrously'),
(2, 'C', 'burst into flames'),
(3, 'A', 'china cabinet'),
(3, 'B', 'curved furniture leg'),
(3, 'C', 'tea cart'),
(4, 'A', 'shallow basket'),
(4, 'B', 'triangular jug'),
(4, 'C', 'padded footrest'),
(5, 'A', 'comforter cover'),
(5, 'B', 'bed skirt'),
(5, 'C', 'long pillow');