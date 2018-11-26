<?php

function find_num_ways($stairs_left, $step_options = array()) {
  $num_ways = 0;
  if (!empty($stairs_left)) {
    foreach ($step_options as $step_option) {
      if (!empty($step_option)) {
        if ($step_option < $stairs_left) {
          $num_ways += find_num_ways($stairs_left - $step_option, $step_options);
        }
        if ($step_option === $stairs_left) {
          $num_ways++;
        }
      }
    }
  }
  return $num_ways;
}

echo find_num_ways(10, array(1, 2));
