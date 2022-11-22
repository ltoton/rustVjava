use std::iter::repeat;

pub fn sierpinski() {
    let order = std::env::args()
        .nth(1)
        .unwrap_or_else(|| "15".to_string())
        .parse::<usize>()
        .unwrap_or_default();
    let mut triangle = vec!["*".to_string()];
    for i in 0..order {
        let space = repeat(' ').take(2_usize.pow(i as u32)).collect::<String>();

        // save original state
        let mut d = triangle.clone();

        // extend existing lines
        d.iter_mut().for_each(|r| {
            let new_row = format!("{}{}{}", space, r, space);
            *r = new_row;
        });

        // add new lines
        triangle.iter().for_each(|r| {
            let new_row = format!("{}{}{}", r, " ", r);
            d.push(new_row);
        });

        triangle = d;
    }
}

fn binarySearch(


fn main() {
    sierpinski();
}