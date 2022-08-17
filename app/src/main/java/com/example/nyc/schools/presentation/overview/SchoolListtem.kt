package com.example.nyc.schools.presentation.overview

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nyc.schools.domain.model.SchoolInformation

@Composable
fun SchoolListItem(
    school: SchoolInformation,
    modifier: Modifier = Modifier
){
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = school.name,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    color = MaterialTheme.colors.onBackground,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 3,
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(4.dp))
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "borough: ${school.borough}",
                fontStyle = FontStyle.Italic,
                color = MaterialTheme.colors.onBackground
            )
            Spacer(modifier = Modifier.height(8.dp))
            var NOT_AVAILABLE = "Not Available"
            Text(
                text = "Graduation Rate: ${school.graduationRate.ifBlank { NOT_AVAILABLE }}",
                fontStyle = FontStyle.Italic,
                color = MaterialTheme.colors.onBackground
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Total Number Of Students: ${school.totalStudents.ifBlank { NOT_AVAILABLE }}",
                fontStyle = FontStyle.Italic,
                color = MaterialTheme.colors.onBackground
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "College Placement Rates: ${school.collegeCareerRate.ifBlank { NOT_AVAILABLE }}",
                fontStyle = FontStyle.Italic,
                color = MaterialTheme.colors.onBackground
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Contact: ${school.email}",
                fontStyle = FontStyle.Italic,
                color = MaterialTheme.colors.onBackground
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "website: ${school.website}",
                fontStyle = FontStyle.Italic,
                color = MaterialTheme.colors.onBackground
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "zipcode: ${school.zip}",
                fontStyle = FontStyle.Italic,
                color = MaterialTheme.colors.onBackground
            )

        }
    }
}