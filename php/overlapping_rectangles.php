<?php

function find_area_overlapping($r1, $r2) {
  $r1_bl = $r1[0];
  $r1_sx = $r1_bl[0];
  $r1_sy = $r1_bl[1];
  $r1_tr = $r1[1];
  $r1_fx = $r1_tr[0];
  $r1_fy = $r1_tr[1];

  $r2_bl = $r2[0];
  $r2_sx = $r2_bl[0];
  $r2_sy = $r2_bl[1];
  $r2_tr = $r2[1];
  $r2_fx = $r2_tr[0];
  $r2_fy = $r2_tr[1];

  if ($r2_sx > $r1_sx) {
    $isx = $r2_sx;
  } else {
    $isx = $r1_sx;
  }
  if ($r2_fx < $r1_fx) {
    $ifx = $r2_fx;
  } else {
    $ifx = $r1_fx;
  }
  echo $isx;
  echo $ifx;
}

echo overlappingArea(
  array(
    array(2, 1),//bottom left
    array(5, 5)//top right
  ),
  array(
    array(3, 2),
    array(5, 7)
  )
);

function overlappingArea($r1, $r2) {
  $x_overlap = max(0, min($r1.right, $r2.right) - max($r1.left, $r2.left));
  $y_overlap = max(0, min($r1.bottom, $r2.bottom) - max($r1.top, $r2.top));
  $overlapArea = $x_overlap * $y_overlap;
}
