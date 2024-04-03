#!/usr/bin/perl
use strict;
use warnings;

open my $fh, '<', 'file.txt' or die "Could not open file: $!";

my %count;

while (my $line = <$fh>) {

    my @words = split ' ', $line;

    for my $word (@words) {
        $count{$word}++;
    }
}

for my $word (keys %count) {
    print "$word: $count{$word}\n";
}

close $fh;