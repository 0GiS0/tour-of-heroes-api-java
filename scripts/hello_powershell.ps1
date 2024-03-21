# Create a hashtable to store the words and their counts
$counts = @{ }

# Read the file line by line
Get-Content -Path .\file.txt | ForEach-Object {
    # Split the line into words
    $words = $_ -split ' '

    # Increment the count for each word
    foreach ($word in $words)
    {
        if ( $counts.ContainsKey($word))
        {
            $counts[$word]++
        }
        else
        {
            $counts[$word] = 1
        }
    }
}

# Print the count of each word
$counts.GetEnumerator() | ForEach-Object {
    Write-Output ("{0}: {1}" -f $_.Key, $_.Value)
}