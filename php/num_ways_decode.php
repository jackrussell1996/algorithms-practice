<?php

$map = array(
  'a' => '1',
  'b' => '2',
  'c' => '3',
  'd' => '4',
  'e' => '5',
  'f' => '6',
  'g' => '7',
  'h' => '8',
  'i' => '9',
  'j' => '10',
  'k' => '11',
  'l' => '12',
  'm' => '13',
  'n' => '14',
  'o' => '15',
  'p' => '16',
  'q' => '17',
  'r' => '18',
  's' => '19',
  't' => '20',
  'u' => '21',
  'v' => '22',
  'w' => '23',
  'x' => '24',
  'y' => '25',
  'z' => '26',
);

function find_num_ways_decode($data, $map, $memo) {
  $num_ways = 0;
  if (is_string($data) && strlen($data)) {
    foreach ($map as $from) {
      $from_length = strlen($from);
      $data_snippet = substr($data, 0, $from_length);
      if ($data_snippet === $from) {
        $next_data = substr($data, $from_length);
        if (strlen($next_data)) {
          // if (!empty($memo[]))
          $num_ways += find_num_ways_decode($next_data, $map);
        }
        else {
          $num_ways++;
        }
      }
    }
  }
  return $num_ways;
}

echo find_num_ways_decode('112', $map);
